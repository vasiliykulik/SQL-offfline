package java.offline5;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Стрела on 09.12.2016.
 */
public class Preparing {
    public static void main(String[] args) {
        // Example 204. Controlling BootstrapServiceRegistry building
        BootstrapServiceRegistryBuilder bootstrapRegistryBuilder =
                new BootstrapServiceRegistryBuilder();
// add a custom ClassLoader
        bootstrapRegistryBuilder.applyClassLoader(customClassLoader);
// manually add an Integrator
        bootstrapRegistryBuilder.applyIntegrator(customIntegrator);

        BootstrapServiceRegistry bootstrapRegistry = bootstrapRegistryBuilder.build();

        // Example 205. Building a BootstrapServiceRegistryBuilder
// An example using an implicitly built BootstrapServiceRegistry
        StandardServiceRegistryBuilder standardRegistryBuilder =
                new StandardServiceRegistryBuilder();

// An example using an explicitly built BootstrapServiceRegistry
        BootstrapServiceRegistry bootstrapRegistry =
                new BootstrapServiceRegistryBuilder().build();

        StandardServiceRegistryBuilder standardRegistryBuilder =
                new StandardServiceRegistryBuilder(bootstrapRegistry);


        // Example 206. Configuring a MetadataSources
        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().build();

        MetadataSources sources = new MetadataSources( standardRegistry );

// alternatively, we can build the MetadataSources without passing
// a service registry, in which case it will build a default
// BootstrapServiceRegistry to use.  But the approach shown
// above is preferred
// MetadataSources sources = new MetadataSources();

// add a class using JPA/Hibernate annotations for mapping
        sources.addAnnotatedClass( MyEntity.class );

// add the name of a class using JPA/Hibernate annotations for mapping.
// differs from above in that accessing the Class is deferred which is
// important if using runtime bytecode-enhancement
        sources.addAnnotatedClassName( "org.hibernate.example.Customer" );

// Read package-level metadata.
        sources.addPackage( "hibernate.example" );

// Read package-level metadata.
        sources.addPackage( MyEntity.class.getPackage() );

// Adds the named hbm.xml resource as a source: which performs the
// classpath lookup and parses the XML
        sources.addResource( "org/hibernate/example/Order.hbm.xml" );

// Adds the named JPA orm.xml resource as a source: which performs the
// classpath lookup and parses the XML
        sources.addResource( "org/hibernate/example/Product.orm.xml" );

// Read all mapping documents from a directory tree.
// Assumes that any file named *.hbm.xml is a mapping document.
        sources.addDirectory( new File( ".") );

// Read mappings from a particular XML file
        sources.addFile( new File( "./mapping.xml") );

// Read all mappings from a jar file.
// Assumes that any file named *.hbm.xml is a mapping document.
        sources.addJar( new File( "./entities.jar") );

// Read a mapping as an application resource using the convention that a class named foo.bar.MyEntity is
// mapped by a file named foo/bar/MyEntity.hbm.xml which can be resolved as a classpath resource.
        sources.addClass( MyEntity.class );


      //  Example 208. Configuring a MetadataSources with method chaining

        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().build();

        MetadataSources sources = new MetadataSources( standardRegistry )
                .addAnnotatedClass( MyEntity.class )
                .addAnnotatedClassName( "org.hibernate.example.Customer" )
                .addResource( "org/hibernate/example/Order.hbm.xml" )
                .addResource( "org/hibernate/example/Product.orm.xml" );


        // Example 209. Building Metadata via MetadataBuilder

        ServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().build();

        MetadataSources sources = new MetadataSources( standardRegistry );

        MetadataBuilder metadataBuilder = sources.getMetadataBuilder();

// Use the JPA-compliant implicit naming strategy
        metadataBuilder.applyImplicitNamingStrategy(
                ImplicitNamingStrategyJpaCompliantImpl.INSTANCE );

// specify the schema name to use for tables, etc when none is explicitly specified
        metadataBuilder.applyImplicitSchemaName( "my_default_schema" );

// specify a custom Attribute Converter
        metadataBuilder.applyAttributeConverter( myAttributeConverter );

        Metadata metadata = metadataBuilder.build();


      //  Example 210. Native Bootstrapping - Putting it all together
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "org/hibernate/example/hibernate.cfg.xml" )
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass( MyEntity.class )
                .addAnnotatedClassName( "org.hibernate.example.Customer" )
                .addResource( "org/hibernate/example/Order.hbm.xml" )
                .addResource( "org/hibernate/example/Product.orm.xml" )
                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .applyBeanManager( getBeanManager() )
                .build();

       // Example 211. Building SessionFactory via SessionFactoryBuilder
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "org/hibernate/example/hibernate.cfg.xml" )
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass( MyEntity.class )
                .addAnnotatedClassName( "org.hibernate.example.Customer" )
                .addResource( "org/hibernate/example/Order.hbm.xml" )
                .addResource( "org/hibernate/example/Product.orm.xml" )
                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

// Supply an SessionFactory-level Interceptor
        sessionFactoryBuilder.applyInterceptor( new CustomSessionFactoryInterceptor() );

// Add a custom observer
        sessionFactoryBuilder.addSessionFactoryObservers( new CustomSessionFactoryObserver() );

// Apply a CDI BeanManager ( for JPA event listeners )
        sessionFactoryBuilder.applyBeanManager( getBeanManager() );

        SessionFactory sessionFactory = sessionFactoryBuilder.build();

    }
}
