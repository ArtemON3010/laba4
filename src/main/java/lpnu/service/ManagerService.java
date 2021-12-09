package lpnu.service;

public interface ManagerService {
    void approve(Long lotId);
    void deactivate(Long lotId);
    void delete(Long lotId);
}
