package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "annual_day_offs")
class AnnualDayOff {
    @Id
    String _id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    String annualDayOffId
    List<String> organizationId
    Instant startDayOff
    Instant endDayOff
    Instant createdAt
    Instant modifiedAt
}
