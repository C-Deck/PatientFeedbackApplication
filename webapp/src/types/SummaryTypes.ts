import { UserResponse } from "./User"

export type SummaryProps = UserResponse & {
  onEditResponse(): void
  onSaveReponse(): void
}