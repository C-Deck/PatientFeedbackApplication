import { UserResponse } from "../../../types/User"

export type FeedbackProps = {
  patientName: string,
  doctorLastName: string,
  diagnosis: string,
  currentResponse?: UserResponse
  reportUserResponse(userReponse: UserResponse): void
}

export type DiagnosisResponse = "Yes" | "No"