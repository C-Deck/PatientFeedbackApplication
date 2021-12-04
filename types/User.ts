export type Patient = {
  id: string,
  active: boolean,
  name: Name,
  contact: Contact[],
  gender: Gender,
  birthDate: string,
  address: Address[]
}

export type Contact = {
  system: "email" | "phone", // Assuming these are the possible systems
  value: string,
  use: "work" | "home" | "mobile" // Assuming these are the possible uses
}

export type Address = {
  use: string,
  line: string[]
}

// Using these two for simplicity sake
export type Gender = "female" | "male"

export type Doctor = {
  id: string,
  name: Name
}

export type Name = {
  family: string,
  given: string[],
  // The Doctor name didn't have the text, but the patient name did
  text?: string
}

export type UserResponse = {
  doctorRecommendation: number,
  understandsDiagnosis: "Yes" | "No",
  diagnosisThoughts: string
}