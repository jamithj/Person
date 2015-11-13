package code
package model
package canonical

import org.specs2.mutable.Specification
import net.liftweb.json._
import net.liftweb.json.Serialization.{read => sread, write => swrite}
import org.specs2.mutable.Specification
import org.specs2.specification.AroundExample
import org.specs2.execute.Result
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.execute.Pending
import org.joda.time.{ DateTime => JodaDateTime}

@RunWith(classOf[JUnitRunner])
class PersonSpecs extends Specification {
  implicit val formats = Serialization.formats(NoTypeHints)
  "A person" should {
    "behave as a value object" in {
      val a = new Person("username")
      val b = new Person("username")
      a must beEqualTo(b)
    }

    val dateOfBirth = (new JodaDateTime(2003,1,1,0,0,0,0)).toDate    
    val academicPerson = AcademicPerson(
      "dtennant", 2585454 ,1234L,"Doctor","David",List(),"Tennant",List("David"),"Tennant",
      Address(List("1 Every Street","Every Suburb"),"Cities","States","0000","Countries"),
      Contact("thedoctor@justthedoctor.net", List(),List("1234-5678")),
      "male",dateOfBirth,"staffMemberIndicator","N/A","N/A"
    )
    "academic person serialize natively" in {
      val expectedJson = """{"username":"dtennant","academicId":2585454,"applicantId":1234,"title":"Doctor","firstName":"David","otherNames":[],"preferredGivenName":"Tennant","givenNames":["David"],"surname":"Tennant","address":{"addressLines":["1 Every Street","Every Suburb"],"city":"Cities","state":"States","postcode":"0000","country":"Countries"},"contactDetails":{"email":"thedoctor@justthedoctor.net","alternateEmails":[],"phone":["1234-5678"]},"gender":"male","dateOfBirth":"2002-12-31T13:00:00.000Z","staffMemberIndicator":"staffMemberIndicator","deceasedIndicator":"N/A","citizenship":"N/A"}"""
      val json = academicPerson.toJson
      json must beEqualTo(expectedJson)
    }
    "academic person deserialize reflexively" in {
      val json = academicPerson.toJson
      val deserialized = sread[AcademicPerson](json)
      deserialized must beEqualTo(academicPerson)
    }
    
    val accountHolder = AccountHolder("dtennant",List("dn"),33112,"Mr","cn",List("ou"),"","Staff","Analyst Programmer",List("D"),"Tennant","David",
        Contact("thedoctor@justthedoctor.net", Nil,List("1234-5678")),"Y")
    "account holder serialize natively" in {
      val expectedJson = """{"username":"dtennant","dn":["dn"],"employeeNumber":33112,"personaltitle":"Mr","cn":"cn","ou":["ou"],"monashouname":"","monashoucategory":"Staff","title":"Analyst Programmer","initials":["D"],"surname":"Tennant","givenName":"David","contactDetails":{"email":"thedoctor@justthedoctor.net","alternateEmails":[],"phone":["1234-5678"]},"staffMemberIndicator":"Y"}"""
      val json = accountHolder.toJson
      json must beEqualTo(expectedJson)
    }
    "account holder deserialize reflexively" in {
      val json = accountHolder.toJson
      val deserialized = sread[AccountHolder](json)
      deserialized must beEqualTo(accountHolder)
    }
  }
}
