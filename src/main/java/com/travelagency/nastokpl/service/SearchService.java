package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.entity.City;
import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.repository.TripRepository;
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

    @PersistenceContext
    private EntityManager entityManager;

    public List<Trip> findTripsByCriteria(Integer availableAdultSeats, BigDecimal priceAdult, LocalDate startDate, LocalDate endDate,
                                          Integer durationDays, String mealType, BigDecimal priceChild, Boolean promoted, Integer availableChildSeats, City departureCityId, City destinationCityId) {

//        Criteria Builder Initialization
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trip> criteriaQuery = criteriaBuilder.createQuery(Trip.class);
        Root<Trip> root = criteriaQuery.from(Trip.class);

//Constructing the Predicate
        List<Predicate> predicates = new ArrayList<>();
        if (availableAdultSeats != null) {
            predicates.add(criteriaBuilder.equal(root.get("availableAdultSeats"), availableAdultSeats));
        }
        if (priceAdult != null) {
            predicates.add(criteriaBuilder.equal(root.get("priceAdult"), priceAdult));
        }
        if (startDate != null) {
            predicates.add(criteriaBuilder.equal(root.get("startDate"), startDate));
        }
        if (endDate != null) {
            predicates.add(criteriaBuilder.equal(root.get("endDate"), endDate));
        }
        if (durationDays != null) {
            predicates.add(criteriaBuilder.equal(root.get("durationDays"), durationDays));
        }
        if (mealType != null) {
            predicates.add(criteriaBuilder.equal(root.get("mealType"), mealType));
        }
        if (priceChild != null) {
            predicates.add(criteriaBuilder.equal(root.get("priceChild"), priceChild));
        }
        if (promoted != null) {
            predicates.add(criteriaBuilder.equal(root.get("promoted"), promoted));
        }
        if (availableChildSeats != null) {
            predicates.add(criteriaBuilder.equal(root.get("availableChildSeats"), availableChildSeats));
        }
        if (departureCityId != null) {
            predicates.add(criteriaBuilder.equal(root.get("departureCityId"), departureCityId));
        }
        if (destinationCityId != null) {
            predicates.add(criteriaBuilder.equal(root.get("destinationCityId"), destinationCityId));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

//        Executing the Query
        TypedQuery<Trip> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
