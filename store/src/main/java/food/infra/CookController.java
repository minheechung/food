package food.infra;

import food.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/cooks")
@Transactional
public class CookController {

    @Autowired
    CookRepository cookRepository;

    @RequestMapping(
        value = "/cooks/{id}/isaccept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook isaccept(
        @PathVariable(value = "id") Long id,
        @RequestBody IsacceptCommand isacceptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/isaccept  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.isaccept(isacceptCommand);

        cookRepository.save(cook);
        return cook;
    }

    @RequestMapping(
        value = "/cooks/{id}/cookstart",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook cookstart(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/cookstart  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.cookstart();

        cookRepository.save(cook);
        return cook;
    }
}
//>>> Clean Arch / Inbound Adaptor
