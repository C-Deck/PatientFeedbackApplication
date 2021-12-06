import React, { useState, useEffect, useRef } from 'react'
import { Button, Spin } from 'antd'
import { UserResponse } from './types/User'
import Feedback from './components/Feedback'
import Summary from './components/Summary'
import { PatientFeedbackInformation } from './types/FeedbackTypes'
import FeedbackApi from './api/FeedbackApi'
import PatientResponseApi from './api/PatientResponseApi'
import './App.css'
import 'antd/dist/antd.css'

// Used for testing the frontend without the backend "GET"
const defaultFeedbackProps = {
  patientName: "Tendo",
  doctorLastName: "Patrick",
  diagnosis: "Cancer"
}

const APPOINTMENT_ID = "be142dc6-93bd-11eb-a8b3-0242ac130003"

const getFeedbackProps = (patientInfo: PatientFeedbackInformation) => {
  const patientName = patientInfo.patient.first
  const doctorLastName = patientInfo.doctor.last
  const diagnosis = patientInfo.diagnosis.description

  return { patientName, doctorLastName, diagnosis }
}

const App: React.FC = () => {
  const [patientFeedbackInformation, setPatientFeedbackInformation] = useState<PatientFeedbackInformation>()
  const [userResponse, setUserResponse] = useState<UserResponse | undefined>()
  const [cachedUserResponse, setCachedUserResponse] = useState<UserResponse | undefined>()
  const [hasSubmitted, setHasSubmitted] = useState<boolean>(false)

  useEffect(() => {
    // Make sure the retrieve is only called the first time
    if (!patientFeedbackInformation) {
      FeedbackApi.getPatientFeedbackInformation(APPOINTMENT_ID).then(feedbackInfo => {
        setPatientFeedbackInformation(feedbackInfo)
      }).catch((e: any) => {
        console.log(e)
      })
    }
  })

  const onSaveReponse = () => {
    if (!hasSubmitted) {
      const appointmentId = APPOINTMENT_ID
      PatientResponseApi.submitPatientFeedback({...userResponse!, appointmentId}).then(() => {
        console.log("Successfully Saved Response")
        setHasSubmitted(true)
      }).catch((e: any) => {
        console.log(e)
      })
      
    } 

    setUserResponse(undefined)
    setCachedUserResponse(undefined)
  }

  const onEditResponse = () => {
    setCachedUserResponse(userResponse)
    setUserResponse(undefined)
  }

  const onReview = () => {
    PatientResponseApi.getPatientFeedback(APPOINTMENT_ID).then(patientFeedback => {
      const { doctorRecommendation, diagnosisThoughts, understandsDiagnosis } = patientFeedback
      setUserResponse({ doctorRecommendation, diagnosisThoughts, understandsDiagnosis })
    })
  }

  return (
    <div className="App">
      {patientFeedbackInformation ? // Show loading spinner until data retrieved from backend
        (userResponse ? 
          (<Summary {...userResponse} onEditResponse={onEditResponse} onSaveReponse={onSaveReponse} />) : 
          (<Feedback 
            {...getFeedbackProps(patientFeedbackInformation)}
            reportUserResponse={setUserResponse}
            currentResponse={cachedUserResponse}
            hasSubmitted={hasSubmitted}
            onReview={onReview}
          />)
        )
         : (<Spin />)
      }
      <br/>
    </div>
  )
}

export default App
