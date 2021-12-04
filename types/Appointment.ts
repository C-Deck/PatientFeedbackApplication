// I would prefer to do hard typing here, but I don't know all the possible values
export type AppointmentStatus = "finished" | string

export type AppointmentPeriod = {
  start: string,
  end: string
}

// I will assume there are more possibilities for fields in this type
export type AppointmentType = {
  text: string
}

export type Appointment = {
  id: string,
  status: AppointmentStatus,
  type: AppointmentType[],
  subjectId: string,
  actorId: string,
  period: AppointmentPeriod
}