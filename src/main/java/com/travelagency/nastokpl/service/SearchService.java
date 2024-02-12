package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.models.CityEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.repositories.TripRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SearchService {

    @Autowired
    private TripRepository tripRepository;
//
//    public List<TripEntity> findTripsByCriteria(Integer availableAdultSeats, BigDecimal priceAdult) {
//        if (availableAdultSeats != null && priceAdult != null) {
//            // If both availableSeats and adultPrice are provided, search for trips with matching criteria
//            return tripRepository.findByAvailableAdultSeatsAndPriceAdult(availableAdultSeats, priceAdult);
//        } else if (availableAdultSeats != null) {
//            // If only availableSeats is provided, search for trips with matching available adult seats
//            return tripRepository.findByAvailableAdultSeats(availableAdultSeats);
//        } else if (priceAdult != null) {
//            // If only adultPrice is provided, search for trips with matching price for adults
//            return tripRepository.findByPriceAdult(priceAdult);
//        } else {
//            // If no criteria are provided, return all trips
//            return tripRepository.findAll();
//        }
//    }

    //OPTION 2
    @PersistenceContext
    private EntityManager entityManager;

    public List<TripEntity> findTripsByCriteria(Integer availableAdultSeats, BigDecimal priceAdult, LocalDate startDate, LocalDate endDate,
                                          Integer durationDays, String mealType, BigDecimal priceChild, Boolean promoted, Integer availableChildSeats, TripEntity departureCityId, TripEntity destinationCityId) {

//        Criteria Builder Initialization
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TripEntity> criteriaQuery = criteriaBuilder.createQuery(TripEntity.class);
        Root<TripEntity> root = criteriaQuery.from(TripEntity.class);

//Constructing the Predicate
        List<Predicate> predicates = new ArrayList<>();
        if (availableAdultSeats != null) {
            predicates.add(criteriaBuilder.equal(root.get("available_adult_seats"), availableAdultSeats));
        }
        if (priceAdult != null) {
            predicates.add(criteriaBuilder.equal(root.get("price_adult"), priceAdult));
        }
        if (startDate != null) {
            predicates.add(criteriaBuilder.equal(root.get("start_date"), startDate));
        }
        if (endDate != null) {
            predicates.add(criteriaBuilder.equal(root.get("end_date"), endDate));
        }
        if (durationDays != null) {
            predicates.add(criteriaBuilder.equal(root.get("duration_days"), durationDays));
        }
        if (mealType != null) {
            predicates.add(criteriaBuilder.equal(root.get("meal_type"), mealType));
        }
        if (priceChild != null) {
            predicates.add(criteriaBuilder.equal(root.get("price_child"), priceChild));
        }
        if (promoted != null) {
            predicates.add(criteriaBuilder.equal(root.get("promoted"), promoted));
        }
        if (availableChildSeats != null) {
            predicates.add(criteriaBuilder.equal(root.get("available_child_seats"), availableChildSeats));
        }
        if (departureCityId != null) {
            predicates.add(criteriaBuilder.equal(root.get("departure_city_id"), departureCityId));
        }
        if (destinationCityId != null) {
            predicates.add(criteriaBuilder.equal(root.get("destination_city_id"), destinationCityId));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

//        Executing the Query
        TypedQuery<TripEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
