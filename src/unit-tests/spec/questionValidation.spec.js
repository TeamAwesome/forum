describe("QuestionValidation", function() {
        var validation;

        beforeEach(function() {
                validation = new Validation();
        });


        describe("Validating Title", function() {
                describe("When Empty Title ", function() {
                        it("Should Display 'ATTENTION!  Title is empty.' ", function() {
                                expect(validation.checkTitle("")).toEqual("ATTENTION!  Title is empty.");
                        });
                });
                describe("When Title is more than 100 characters", function() {
                        it("Should Display 'ATTENTION!  100 Characters only.' ", function() {
                                var title = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678905";
                                var result = validation.checkTitle(title);
                                expect(result).toEqual("ATTENTION!  100 Characters only.");
                        });
                });
                describe("When Title is no more than 100 characters", function() {
                        it("Should Display '' ", function() {
                                var title = "see, it's ok.";
                                var result = validation.checkTitle(title);
                                expect(result).toEqual("87 Characters Remaining");
                        });
                });

        });

        describe("Validating Description", function() {
                        describe("When Empty Description ", function() {
                                it("Should Display 'ATTENTION!  Description is empty.' ", function() {
                                        expect(validation.checkDescription("")).toEqual("ATTENTION!  Description is empty.");
                                });
                        });
                        describe("When Description is more than 500 characters", function() {
                                it("Should Display 'ATTENTION!  500 Characters only.' ", function() {
                                        var description = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
                                        description += description;
                                        description += description;
                                        description += description;
                                        description += description;
                                        description += "-";
                                        var result = validation.checkDescription(description);
                                        expect(result).toEqual("ATTENTION!  500 Characters only.");
                                });
                        });
                        describe("When Description is no more than 500 characters", function() {
                                it("Should Display '' ", function() {
                                        var title = "checkDescription is ok.";
                                        var result = validation.checkDescription(title);
                                        expect(result).toEqual("477 Characters Remaining");
                                });
                        });

                });

        describe("Validating Title and Description", function() {
                describe("When Empty Title ", function() {
                        it("Should return false ", function() {
                                expect(validation.checkTitleAndDescription("", "aaaa")).toEqual(false);
                        });
                });
                describe("When Empty Description ", function() {
                        it("Should return false ", function() {
                                expect(validation.checkTitleAndDescription("title", "")).toEqual(false);
                        });
                });
                describe("When Title is more than 100 characters", function() {
                        it("Should return false ", function() {
                                var title = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678905";
                                expect(validation.checkTitleAndDescription(title, "aaaa")).toEqual(false);
                        });
                });
                describe("When Description is more than 500 characters", function() {
                        it("Should return false ", function() {
                                var description = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
                                description += description;
                                description += description;
                                description += description;
                                description += description;
                                description += "-";
                                expect(validation.checkTitleAndDescription("tt", description)).toEqual(false);
                        });
                });

        });


});

