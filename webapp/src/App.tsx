import React, { useState } from 'react'
import { UserResponse } from '../../types/User'
import Feedback from './components/Feedback'
import Summary from './components/Summary'

import './App.css'
import 'antd/dist/antd.css'

const defaultFeedbackProps = {
  patientName: "Tendo",
  doctorLastName: "Patrick",
  diagnosis: "Cancer"
}

const App: React.FC = () => {
  const [userResponse, setUserResponse] = useState<UserResponse | undefined>()
  const [cachedUserResponse, setCachedUserResponse] = useState<UserResponse | undefined>()

  const onEditResponse = () => {
    setCachedUserResponse(userResponse)
    setUserResponse(undefined)
  }

  return (
    <div className="App">
      {userResponse ? 
        (<Summary {...userResponse} onEditResponse={onEditResponse} />) : 
        (<Feedback {...defaultFeedbackProps} reportUserResponse={setUserResponse} currentResponse={cachedUserResponse}/>)
      }
    </div>
  )
}

export default App
