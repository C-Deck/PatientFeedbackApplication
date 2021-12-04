import React, { useState, useEffect } from 'react'
import { Card, Button, Input, InputNumber, Radio, RadioChangeEvent, Space } from 'antd'
import { DiagnosisResponse, FeedbackProps } from '../types/FeedbackTypes'

const { TextArea } = Input

const FIRST_STEP = 1
const FINAL_STEP = 3

const Feedback: React.FC<FeedbackProps> = (props: FeedbackProps) => {
  // Track which set of the feedback we are currently on
  const [currentStep, setCurrentStep] = useState(FIRST_STEP)
  // Variables to handle user feedback as we go
  const [doctorRecommendation, setDoctorRecommendation] = useState<number>(10)
  const [diagnosisResponse, setDiagnosisResponse] = useState<DiagnosisResponse>("Yes")
  const [diagnosisThoughts, setDiagnosisThoughts] = useState<string>("")

  useEffect(() => {
    // Check for a response to edit
    if (props.currentResponse) {
      // Reset to first step
      setCurrentStep(FIRST_STEP)

      // Set the response values to edit
      setDoctorRecommendation(props.currentResponse.doctorRecommendation)
      setDiagnosisResponse(props.currentResponse.understandsDiagnosis)
      setDiagnosisThoughts(props.currentResponse.diagnosisThoughts)
    }
  // Only call this effect if the currentResponse value is changed - For editting
  }, [props.currentResponse])


  const firstStep = (
    <div className="Step">
      <p>Hi {props.patientName}, on a scale of 1-10, would you recommend Dr {props.doctorLastName} to a friend or family member?</p>
      <p>1 = Would not recommend</p>
      <p>10 = Would strongly recommend</p>
      <InputNumber min={1} max={10} value={doctorRecommendation} onChange={setDoctorRecommendation} />
    </div>
  )
  
  const onChangeDiagnosisResponse = (e: RadioChangeEvent) => {
    setDiagnosisResponse(e.target.value)
  }

  const secondStep = (
    <div className="Step">
      <p>Thank you. You were diagnosed with {props.diagnosis}. Did Dr {props.doctorLastName} explain how to manage this diagnosis in a way you could understand?</p>
      <Radio.Group value={diagnosisResponse} onChange={onChangeDiagnosisResponse} style={{padding: 10}}>
        <Radio value="Yes">Yes</Radio>
        <Radio value="No">No</Radio>
      </Radio.Group>
    </div>
  )

  const onChangeFeelings: React.ChangeEventHandler<HTMLTextAreaElement> = (e) => {
    setDiagnosisThoughts(e.target.value)
  }

  const thirdStep = (
    <div className="Step">
      <p>We appreciate the feedback, one last question: how do you feel about being diagnosed with {props.diagnosis}?</p>
      <TextArea value={diagnosisThoughts} onChange={onChangeFeelings} rows={4} />
    </div>
  )

  // Get what to show based on the current step
  const getStepView = () => {
    switch (currentStep) {
      case 1:
        return firstStep
      case 2:
        return secondStep
      case 3:
        return thirdStep
      default:
        return (
          <div>
            "Unknown Step"
          </div>
        )
    }
  }

  const nextStep = () => {
    // Confirm there are more steps
    if (currentStep < FINAL_STEP) {
      // Go to the next step
      setCurrentStep(currentStep + 1)
    } else {
      // Report response 
      props.reportUserResponse({
        doctorRecommendation,
        understandsDiagnosis: diagnosisResponse,
        diagnosisThoughts
      })
    }
  }

  return (
    <div className="Feedback">
      <Space>
      <Card
        bordered={true}
        title="Patient Feedback"
        style={{ width: 600, margin: 100 }}
      >
        {getStepView()}
        <br />
        <Button type="primary" onClick={nextStep}>
          {currentStep === FINAL_STEP ? "Finish" : "Continue"}
        </Button>
      </Card>
      </Space>
    </div>
  )
}

export default Feedback