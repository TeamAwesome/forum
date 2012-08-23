function Validation()
{
    this.content = "";
    this.number = 0;

    this.checkIfTitleIsEmpty = function(title){
            var remaining = countRemainingCharacters(title, 100);
            if(remaining == 100){
                  return "A Question must have a title.";
            }
            return "";
   }

    this.checkNumberOfRemainingCharactersInTheTitle = function(title){
            var remaining = countRemainingCharacters(title, 100);
            if(remaining > 0 && remaining <= 100 )
                return remaining.toString()+" Characters Remaining";
            return "";
    }

    this.checkIfDescriptionIsEmpty = function(description){
            var remaining = countRemainingCharacters(description, 500);
            if(remaining == 0){
                  return "The Description should not be empty.";
            }
            return "";
   }

    this.checkNumberOfRemainingCharactersInTheDescription = function(description){
            var remaining = countRemainingCharacters(description, 500);
            if(remaining > 0 && remaining <= 500 )
                return remaining.toString()+" Characters Remaining";
            return "";
    }

    this.checkIfDescriptionHasOver500Characters = function(description){
            var remaining = countRemainingCharacters(description, 500);
            if(remaining > 500 )
                return "AAAHHH. Too many characters.";
            return "";
    }


   this.checkDescription = function(description){
       if(characterNumber(description)>0 && characterNumber(description)<=500)
            return true;
       return false;
   }

    this.checkTitle = function(title){
          if(characterNumber(title)>0 && characterNumber(title)<=100)
               return true;
          return false;
      }

    var characterNumber = function(content){
        return content.length;
    }

   var countRemainingCharacters = function(content, number){
       this.content = content;
       this.number = new Number(number);
       return new Number(number) - characterNumber(content);
   }

}