import { PatientFeedbackInformation } from "../types/FeedbackTypes"
import { RestManager } from "./RestManager"

const api = new RestManager('feedback')

export default class FeedbackApi {
  public static async getPatientFeedbackInformation(appointmentId: string) {
    return api.get<PatientFeedbackInformation>(`/appointment/${appointmentId}`)
  }
}