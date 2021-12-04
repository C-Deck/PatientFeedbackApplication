import { UserResponse } from "../../../types/User"

export type SummaryProps = UserResponse & {
  onEditResponse(): void
}