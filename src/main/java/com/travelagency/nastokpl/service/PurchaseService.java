package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PurchaseService {

    @Autowired
    private TripRepository tripRepository;
}
