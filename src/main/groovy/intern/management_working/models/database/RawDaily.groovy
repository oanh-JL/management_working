package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "raw_dailies")
class RawDaily {
    @Id
    String _id
    String fingerId
    String userName
    Instant date
    Instant checkIn
    Instant checkOut
    Instant createdAt
    Instant modifiedAt
}
