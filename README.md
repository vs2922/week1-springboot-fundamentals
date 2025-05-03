Spring Boot pharma inventory system

- Project setup with Spring Boot, Spring Data JPA, H2 in-memory database
- Domain models: Medicine, Pallet, Task with enums for DrugCondition & DeliveryPriority
- JPA repositories with custom query methods (expired meds, urgent tasks, counts)
- Service layer for business logic and transactional operations
- REST controllers for CRUD and reporting endpoints (expired medicines, urgent tasks, refrigerated meds, pallets by priority, summary)
- Global exception handling with ResourceNotFound and validation errors
- Application configuration via application.yml







