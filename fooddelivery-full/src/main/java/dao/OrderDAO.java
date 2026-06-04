package dao;

import model.Order;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class OrderDAO {

    // Save a new order
    public boolean placeOrder(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Get all orders of a specific user
    public List<Order> getOrdersByUser(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Order o WHERE o.user.id = :userId ORDER BY o.orderDate DESC";
            Query<Order> query = session.createQuery(hql, Order.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Total orders count by user
    public long getTotalOrdersByUser(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(o) FROM Order o WHERE o.user.id = :userId";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("userId", userId);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Total amount spent by user
    public double getTotalSpentByUser(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT SUM(o.totalPrice) FROM Order o WHERE o.user.id = :userId";
            Query<Double> query = session.createQuery(hql, Double.class);
            query.setParameter("userId", userId);
            Double result = query.uniqueResult();
            return result != null ? result : 0.0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // Most ordered food item by user
    public String getFavoriteFood(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT o.foodItem FROM Order o WHERE o.user.id = :userId " +
                         "GROUP BY o.foodItem ORDER BY COUNT(o.foodItem) DESC";
            Query<String> query = session.createQuery(hql, String.class);
            query.setParameter("userId", userId);
            query.setMaxResults(1);
            String result = query.uniqueResult();
            return result != null ? result : "No orders yet";
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }
}
