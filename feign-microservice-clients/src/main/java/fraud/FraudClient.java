package fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fraud")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check-history/{customerId}")
    public ResponseEntity<FraudCheckPayload> getFraudCheckHistory(@PathVariable("customerId") Long customerId);


}
