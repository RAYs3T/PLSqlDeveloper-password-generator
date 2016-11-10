/**
 * Simple class to generate passwords for the plsql-developer (.connection) files. The Key is stored
 * within the password (first 4 digits). So since it does not really matters then, its can just be
 * 2001
 *
 * Original calculation is (key between 1 and 999) + 2000.
 *
 * Inspired by:
 * <a href="https://adamcaudill.com/2016/02/02/plsql-developer-nonexistent-encryption/">Adam
 * Caudill</a>
 */
public final class PLSqlDeveloperProprietaryEncryptionUtil
{
   private PLSqlDeveloperProprietaryEncryptionUtil()
   {
      // I won't be an instance :(
   }

   private static final int KEY = 2001;

   public static final String encrypt(final String raw)
   {
      String ret = "";
      for (int i = 0; i < raw.length(); i++)
      {
         final int mask = raw.charAt(i) << 4;
         final int n = (mask ^ (KEY + ((i + 1) * 10))) + 1000;
         ret += String.valueOf(n);
      }
      return String.valueOf(KEY) + ret;
   }

}
