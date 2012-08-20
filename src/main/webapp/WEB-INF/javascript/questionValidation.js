function Validation()
{
    this.content = "";
    this.number = 0;

    this.checkTitle = function(title){
        var remaining = check(title, 100);
        if( remaining == number)
              return "ATTENTION!  Title is empty.";
        if(remaining < 0)
            return "ATTENTION!  100 Characters only.";
        if(remaining > 0 && remaining <= 100 )
            return remaining.toString()+" Characters Remaining";
        return "ATTENTION!  Title is empty.";
   }

    this.checkDescription = function(description){
        var remaining = check(description, 500);
        if( remaining == number)
              return "ATTENTION!  Description is empty.";
        if(remaining < 0)
            return "ATTENTION!  500 Characters only.";
        if(remaining > 0 && remaining <= 500 )
            return remaining.toString()+" Characters Remaining";
        return "ATTENTION!  Description is empty.";
   }

   this.checkTitleAndDescription = function(title, description){
       if(characterNumber(title)>0 && characterNumber(title)<=100
                && characterNumber(description)>0 && characterNumber(description)<=500)
            return true;
       return false;
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