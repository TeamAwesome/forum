function Validation()
{
    this.content = "";
    this.number = 0;

    this.checkUsername = function(username){
        var remaining = check(username, 100);
        if( remaining == number)
              return "ATTENTION!  Username is empty.";

   }


    var characterNumber = function(content){
        return content.length;
    }

   var check = function(content, number){
       this.content = content;
       this.number = new Number(number);
       return new Number(number) - characterNumber(content);
   }

}