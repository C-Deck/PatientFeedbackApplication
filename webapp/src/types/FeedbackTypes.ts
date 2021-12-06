import { Diagnosis } from "./Diagnosis"
import { Doctor, Patient, UserResponse } from "./User"

export type FeedbackProps = {
  patientName: string
  doctorLastName: string
  diagnosis: string
  hasSubmitted: boolean
  currentResponse?: UserResponse
  reportUserResponse(userReponse: UserResponse): void
  onReview(): void
}

export type PatientFeedbackInformation = {
  patient: Patient
  doctor: Doctor
  diagnosis: Diagnosis
}