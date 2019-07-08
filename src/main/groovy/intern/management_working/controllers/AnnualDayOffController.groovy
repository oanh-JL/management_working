package intern.management_working.controllers

import intern.management_working.models.database.AnnualDayOff
import intern.management_working.models.response.SystemResponse
import intern.management_working.services.AnnualDayOffService
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/annual_day_off")
class AnnualDayOffController {

    @Autowired
    AnnualDayOffService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody AnnualDayOff annualDayOff) {
        return service.create(annualDayOff)
    }

//    @GetMapping
//    List<Document> getAll () {
//        return service.getAll()
//    }

    @PutMapping
    ResponseEntity<SystemResponse> update (AnnualDayOff annualDayOff) {
        return service.update(annualDayOff)
    }

    @DeleteMapping
    ResponseEntity<SystemResponse> delete (String _id) {
        return service.delete(_id)
    }
}
