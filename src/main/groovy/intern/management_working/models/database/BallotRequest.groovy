package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant
import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document("ballot_requests")
class BallotRequest {
    @Id
    String _id
    String userId
    String dayOffTypeId
    String reason
    Instant dateFrom
    Instant dateTo
    int status
    Instant createdAt
    Instant modifiedAt
}
