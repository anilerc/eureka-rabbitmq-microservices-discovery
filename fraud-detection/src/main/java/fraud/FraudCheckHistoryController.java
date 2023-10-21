package fraud;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check-history")
@AllArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<FraudCheckPayload> getFraudCheckHistory(@PathVariable("customerId") Long customerId) {

        Boolean isFraud = fraudCheckHistoryService.isCustomerFraud(customerId);

        return new ResponseEntity<>(new FraudCheckPayload(isFraud), HttpStatus.OK);
    }

}
