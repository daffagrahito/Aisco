package aisco.donation;
import aisco.donation.core.Donation;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class DonationFactory
{
    private static final Logger LOGGER = Logger.getLogger(DonationFactory.class.getName());

    private DonationFactory()
    {

    }

    public static Donation createDonation(String fullyQualifiedName, Object... base) {
        Donation record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?>[] constructors = clz.getConstructors();
            Constructor<?> matchingConstructor = null;
    
            // Cari constructor yang cocok dengan jumlah dan tipe argumen
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == base.length) {
                    matchingConstructor = constructor;
                    break;
                }
            }
    
            if (matchingConstructor == null) {
                throw new IllegalArgumentException("No matching constructor found for the given arguments.");
            }
            record = (Donation) matchingConstructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of Donation.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            e.printStackTrace();
            System.exit(20);
        } catch (Exception e) {
            LOGGER.severe("Failed to create instance of Donation.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            e.printStackTrace();
            System.exit(50);
        }
        return record;
    }

}