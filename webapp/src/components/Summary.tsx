import React from 'react'
import { Space, Card, Button, Layout } from 'antd'
import { SummaryProps } from '../types/SummaryTypes'

const { Content, Footer } = Layout

const cardStyle = {
  marginTop: 10
}

const Summary: React.FC<SummaryProps> = (props: SummaryProps) => {
  return (
    <div className="Summary">
      <Layout>
        <Content>
        <Space>
          <Card title="Patient Feedback Summary">
          <h2>Thanks again! Here's what we heard:</h2>
          <Card
            type="inner"
            title="Doctor Recommendation"
            style={{...cardStyle}}
          >
            <h1>{props.doctorRecommendation} out of 10</h1>
          </Card>
          <Card
            type="inner"
            title="Does the Patient Understand the Diagnosis?"
            style={{...cardStyle}}
          >
            <h1>{props.understandsDiagnosis ? "Yes" : "No"}</h1> 
          </Card>
          <Card
            type="inner"
            title="Patient Thoughts on Diagnosis"
            style={{...cardStyle}}
          >
            <h2>{props.diagnosisThoughts}</h2>
          </Card>
          </Card>
        </Space>
        </Content>
        <Footer>
          <Space>
            <Button type="primary" onClick={props.onSaveReponse}>Save</Button>
            <Button type="primary" onClick={props.onEditResponse}>Edit</Button>
          </Space>
        </Footer>
      </Layout>
    </div>
  )
}

export default Summary