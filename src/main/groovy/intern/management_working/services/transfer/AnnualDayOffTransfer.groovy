package intern.management_working.services.transfer

import intern.management_working.models.database.AnnualDayOff
import org.springframework.stereotype.Component

import java.time.Instant

@Component
class AnnualDayOffTransfer {
    static void create(AnnualDayOff annualDayOff) {
        annualDayOff.setStartDayOff(Instant.parse(annualDayOff.getStartDayOff().toString()))
        annualDayOff.setEndDayOff(Instant.parse(annualDayOff.getEndDayOff().toString()))
        annualDayOff.setCreatedAt(Instant.now())
        annualDayOff.setModifiedAt(null)
    }

    static void update(AnnualDayOff annualDayOff) {
        annualDayOff.setStartDayOff(Instant.parse(annualDayOff.getStartDayOff().toString()))
        annualDayOff.setEndDayOff(Instant.parse(annualDayOff.getEndDayOff().toString()))
        annualDayOff.setModifiedAt(annualDayOff.getCreatedAt())
    }
}
