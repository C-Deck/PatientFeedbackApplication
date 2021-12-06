// I would prefer to do hard typing here, but I don't know all the possible values
export type AppointmentStatus = "finished" | string

export type Appointment = {
  id: string,
  status: AppointmentStatus,
  subjectId: string,
  actorId: string,
  type: string,
  startDate: string,
  endDate: string
}

// Unused - built based on JSON
export type AppointmentPeriod = {
  start: string,
  end: string
}

// Unused - built based on JSON
export type AppointmentType = {
  text: string
}
