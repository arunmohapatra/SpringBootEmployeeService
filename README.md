1. In Spring Boot the annotation @Component, @Service and @Repository are all sterotypes used to indicate that a class in Spring-Managed bean.
2. Spring will automatically detect and register it during component scanning ,while they function similarly in terms of bean registration.
3. They carry semantics difference that help with readabilty, maintaninability and sometimes additional behaviours

**Common Purpose:**
-> Mark a class as a **Spring Bean**
-> Are picked by component scanning (e.g. using @ComponentScan of if inside a package scanned by @SpringBootApplication)
-> Allow dependency injection using @Autowired, construction injection

**Differences and When to Use**
Annotation	                    Purpose	                                              Special Behavior / Use Case
@Component	              Generic stereotype for any bean	                  No additional behavior — use for general-purpose components
@Service	                Indicates a service layer bean	                  Semantically indicates business logic; may be used by AOP (e.g., for transactions or metrics)
@Repository	              Indicates a DAO / persistence bean	              Converts JPA exceptions to Spring DataAccessException via PersistenceExceptionTranslationPostProcessor

**When to use Which**
= Use @Component when:
  - Your class is a generic Spring-Managed component that does not fall under service or repository
  - Examples: Utility classes, config handlers and helpers classes
= Use @Service when:
  - This class contains business logic or orchestration
  - You want to make the intent clear: this is the service layer
= Use @Repository
  - This class interacts with a database or data source
  - You want Spring to automatically translate persistnce exceptions
