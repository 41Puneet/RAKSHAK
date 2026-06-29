package com.emergency_service.DTO.Request;

import java.util.List;

public class EmergencyImageRequestDTO {
   private List<String> imgUrl;

   public EmergencyImageRequestDTO(List<String> imgUrl) {
       this.imgUrl = imgUrl;
   }

   public List<String> getImgUrl() {
       return imgUrl;
   }

   public void setImgUrl(List<String> imgUrl) {
       this.imgUrl = imgUrl;
   }
}
