package org.concertManagement.controllers;

import org.concertManagement.entities.dto.VisitorsDTO;
import org.concertManagement.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitors")
public class VisitorController {
    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public @ResponseBody
    VisitorsDTO getAllVisitors(){
        VisitorsDTO visitorsDTO = new VisitorsDTO();
        visitorsDTO.setVisitors(visitorService.getAllVisitors());
        return visitorsDTO;
    }

}
