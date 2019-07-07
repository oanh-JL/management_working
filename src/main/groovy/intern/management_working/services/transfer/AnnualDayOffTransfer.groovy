package intern.management_working.services.transfer

import intern.management_working.models.database.AnnualDayOff
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class AnnualDayOffTransfer {
    void create(AnnualDayOff annualDayOff) {
        annualDayOff.setStartDayOff(LocalDate.parse(annualDayOff.getStartDayOff().toString()))
        annualDayOff.setEndDayOff(LocalDate.parse(annualDayOff.getEndDayOff().toString()))
        annualDayOff.setCreatedAt(LocalDate.now())
        annualDayOff.setModifiedAt(null)
    }

    void update(AnnualDayOff annualDayOff) {
        annualDayOff.setStartDayOff(LocalDate.parse(annualDayOff.getStartDayOff().toString()))
        annualDayOff.setEndDayOff(LocalDate.parse(annualDayOff.getEndDayOff().toString()))
        annualDayOff.setModifiedAt(annualDayOff.getCreatedAt())
    }
}
