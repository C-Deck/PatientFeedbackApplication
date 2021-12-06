export type Patient = {
  id: string,
  active: boolean,
  first: string,
  last: string,
  gender: string,
  birthDate: string
}

export type Doctor = {
  id: string,
  first: string,
  last: string
}

export type UserResponse = {
  doctorRecommendation: number,
  understandsDiagnosis: boolean,
  diagnosisThoughts: string
}

export type PatientResponse = {
  appointmentId: string
} & UserResponse

// Unused - built based on JSON
export type Name = {
  family: string,
  given: string[],
  // The Doctor name didn't have the text, but the patient name did
  text?: string
}

// Unused - built based on JSON
export type Contact = {
  system: "email" | "phone", // Assuming these are the possible systems
  value: string,
  use: "work" | "home" | "mobile" // Assuming these are the possible uses
}

// Unused - built based on JSON
export type Address = {
  use: string,
  line: string[]
}
