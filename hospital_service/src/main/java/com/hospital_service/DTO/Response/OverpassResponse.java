package com.hospital_service.DTO.Response;

import java.util.List;
import com.hospital_service.DTO.Response.Element;

public class OverpassResponse {
    

    private List<Element> elements;

    public OverpassResponse(){

    }
    public OverpassResponse(List<Element>elements){
        this.elements=elements;
    }
    public List<Element>getElements(){
        return elements;
    }
    public void setElements(List<Element>elements){
        this.elements=elements;
    }
}
