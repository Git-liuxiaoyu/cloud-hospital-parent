package com.example.outpatientservice.service.update;

public interface IUpdateOutPatientRecordCommandHandle {
    public void updateById(Long OddId,Long outPatientRecordId,String updateType);
}
