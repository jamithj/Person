package code.model.canonical{
  trait PersonFactory {
    def get(username:String): Either[Exception,Option[Person]]
    def get(fragments:Seq[String]): Either[Exception,Seq[Person]]
  }
  trait AcademicPersonFactory {
    def get(username:String): Either[Exception,Option[AcademicPerson]]
    def get(personId:Long): Either[Exception,Option[AcademicPerson]]
    def get(fragments:Seq[String]): Either[Exception,Seq[AcademicPerson]]
  }
   trait AccountHolderFactory {
    def get(username:String): Either[Exception,Option[AccountHolder]]
    def get(fragments:Seq[String]): Either[Exception,Seq[AccountHolder]]
  }
}
