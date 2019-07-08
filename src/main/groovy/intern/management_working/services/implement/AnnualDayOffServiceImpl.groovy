package intern.management_working.services.implement

import intern.management_working.models.database.AnnualDayOff
import intern.management_working.models.response.SystemResponse
import intern.management_working.repositories.AnnualDayOffRepository
import intern.management_working.services.AnnualDayOffService
import intern.management_working.services.transfer.AnnualDayOffTransfer
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AnnualDayOffServiceImpl implements AnnualDayOffService {

    @Autowired
    AnnualDayOffRepository repository
    @Autowired
    AnnualDayOffTransfer transfer

    @Override
    ResponseEntity<SystemResponse> create(AnnualDayOff annualDayOff) {

        transfer.create(annualDayOff)
        repository.save(annualDayOff)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

//    @Override
//    List<Document> getAll() {
//        return repository.getAllDayOff()
//
//    }

    @Override
    ResponseEntity<SystemResponse> update(AnnualDayOff annualDayOff) {

        AnnualDayOff annualDayOffUpdate = repository.findById(annualDayOff.get_id()).orElse(null)
        if (!annualDayOffUpdate) {
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
        }
        transfer.update(annualDayOff)
        repository.save(annualDayOff)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> delete(String _id) {
        if (repository.deleteById(_id)) {
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }
}
