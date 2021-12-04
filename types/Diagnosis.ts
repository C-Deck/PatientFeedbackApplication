export type Diagnosis = {
  id: string,
  // I am not completely sure what all could be in meta - use any for now
  meta: Record<string, any>,
  status: DiagnosisStatus,
  code: DiagnosisCode,
  appointmentId: string
}

// I would prefer to do hard typing here, but I don't know all the possible values
export type DiagnosisStatus = "final" | string

export type DiagnosisCode = {
  coding: Coding[]
}

export type Coding = {
  system: string,
  code: string,
  name: string
}