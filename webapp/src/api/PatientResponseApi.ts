import { PatientResponse } from "../types/User"
import { RestManager } from "./RestManager"

const api = new RestManager('response')

export default class PatientResponseApi {
  public static async submitPatientFeedback(response: PatientResponse) {
    api.post(`/save`, response)
  }

  public static async getPatientFeedback(appointmentId: string) {
    return api.get<PatientResponse>(`/retrieve/${appointmentId}`)
  }
}