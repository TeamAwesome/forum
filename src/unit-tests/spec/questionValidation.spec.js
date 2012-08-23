describe("QuestionValidation", function() {
        var validation;

        beforeEach(function() {
                validation = new Validation();
        });


        describe("Validating Title", function() {
                describe("When Empty Title ", function() {
                        it("Should Display 'ATTENTION!  Title is empty.' ", function() {
                                expect(validation.checkIfTitleIsEmpty("")).toEqual("The Title should not be empty.");
                        });
                });

                describe("When Title is no more than 100 characters", function() {
                        it("Should Display '' ", function() {
                                var title = "see, it's ok.";
                                var result = validation.checkNumberOfRemainingCharactersInTheTitle(title);
                                expect(result).toEqual("87 Characters Remaining");
                        });
                });

        });

        describe("Validating Description", function() {
                        describe("When Empty Description ", function() {
                                it("Should return false' ", function() {
                                        expect(validation.checkDescription("")).toEqual(false);
                                });
                        });
                        describe("When Description is more than 500 characters", function() {
                                it("Should return false' ", function() {
                                        var description = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
                                        description += description;
                                        description += description;
                                        description += description;
                                        description += description;
                                        description += "-";
                                        var result = validation.checkDescription(description);
                                        expect(result).toEqual(false);
                                });
                        });
                        describe("When Description is no more than 500 characters", function() {
                                it("Should return true", function() {
                                        var title = "checkDescription is ok.";
                                        var result = validation.checkDescription(title);
                                        expect(result).toEqual(true);
                                });
                        });

                });

});

