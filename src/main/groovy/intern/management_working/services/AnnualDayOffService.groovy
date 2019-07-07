package intern.management_working.services

import intern.management_working.models.database.AnnualDayOff
import intern.management_working.models.response.SystemResponse
import org.springframework.http.ResponseEntity

interface AnnualDayOffService {
    ResponseEntity<SystemResponse> create(AnnualDayOff annualDayOff)

    List<AnnualDayOff> getAll()

    ResponseEntity<SystemResponse> update(AnnualDayOff annualDayOff)

    ResponseEntity<SystemResponse> delete(String _id)
}
