export type Diagnosis = {
  id: string,
  status: DiagnosisStatus,
  description: string,
  appointmentId: string
}

// I would prefer to do hard typing here, but I don't know all the possible values
export type DiagnosisStatus = "final" | string

// Unused - built based on JSON
export type DiagnosisCode = {
  coding: Coding[]
}

// Unused - built based on JSON
export type Coding = {
  system: string,
  code: string,
  name: string
}