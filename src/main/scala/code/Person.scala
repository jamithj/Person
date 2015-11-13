import net.liftweb.json.Serialization.{ read => sread, write => swrite }
import java.util.{Date => JavaDate}

package code.model.canonical { 

  class Person(val username: String) {
    lazy val academicPerson: Option[AcademicPerson] = None
    lazy val hrPerson: Option[HrPerson] = None
    lazy val researchPerson: Option[ResearchPerson] = None
    lazy val accountHolder: Option[AccountHolder] = None
    override def equals(obj: Any) = obj != null && obj.isInstanceOf[Person] && obj.asInstanceOf[Person].username == username
    override def hashCode = username.hashCode   
  }

  case class AcademicPerson(username: String, 
                            academicId: Long, 
                            applicantId: Long, 
                            title: String, 
                            firstName: String, 
                            otherNames: Seq[String], 
                            preferredGivenName: String, 
                            givenNames: Seq[String], 
                            surname: String, 
                            address: Address, 
                            contactDetails: Contact, 
                            gender: String, 
                            dateOfBirth: JavaDate, 
                            staffMemberIndicator: String, 
                            deceasedIndicator: String, 
                            citizenship: String) extends NoType{
    def toJson = swrite(this)
  } 
  case class HrPerson()
  case class ResearchPerson()
  case class AccountHolder(username: String, 
                           dn: Seq[String], 
                           employeeNumber: Long, 
                           personaltitle: String, 
                           cn: String, 
                           ou: Seq[String], 
                           monashouname: String, 
                           monashoucategory: String, 
                           title: String, 
                           initials: Seq[String], 
                           surname: String, 
                           givenName: String, 
                           contactDetails: Contact, 
                           staffMemberIndicator: String) extends NoType{
    def toJson = swrite(this)
  } 
}
