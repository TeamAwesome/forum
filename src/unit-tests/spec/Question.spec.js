describe("Question Validation:", function() {
        var question;

        beforeEach(function() {
            question = new Question("This is the title","This is the description");
        });


        describe("On validating title", function() {
            describe("When title is empty", function() {
                    it("Should create the error message", function() {
                        question =  new Question("","This is description");

                        expect(question.isValid()).toBeFalsy();

                        expect(question.messages['title']).toEqual("Title is empty.");
                    });
            });

            describe("When title is not empty", function() {
                    it("Should create the information message with number of characters remaining", function() {
                            question =  new Question("This is title","This is description");

                            expect(question.isValid()).toBeTruthy();

                            expect(question.messages['title']).toEqual("87 characters remaining.");
                    });
            });
        });

        describe("On updating question", function() {

                describe("When title is empty", function() {
                        it("Should create the information message with number of characters remaining", function() {
                            question =  new Question("","This is description");
                            question.updateMessages();
                            expect(question.messages['title']).toEqual("100 characters remaining.");
                        });
                });

                describe("When title is not empty", function() {
                        it("Should create the information message with number of characters remaining", function() {
                                question =  new Question("This is title","This is description");

                                question.updateMessages();

                                expect(question.messages['title']).toEqual("87 characters remaining.");
                        });
                });
                });

        describe("On validating description", function() {

                describe("When description is empty", function() {
                        it("Should create the error message", function() {
                            question =  new Question("This is title","");
                            expect(question.isValid()).toBeFalsy();
                            expect(question.messages['description']).toEqual("Description is empty.");
                        });
                });

                describe("When Description is less than Max Limit", function() {
                        it("Should create the information message with number of characters remaining", function() {
                                question =  new Question("This is title","This is the description");

                                expect(question.isValid()).toBeTruthy();

                                expect(question.messages['description']).toEqual("477 characters remaining.");
                        });
                });

                describe("When Description is at Max Limit", function() {
                        it("Should create the information message with zero characters remaining", function() {
                                description = "";
                                for(var i = 0; i < 500; i++) {
                                    description += "A";
                                }

                                question =  new Question("This is title",description);

                                expect(question.isValid()).toBeTruthy();

                                expect(question.messages['description']).toEqual("0 characters remaining.");
                        });
                });

                describe("When Description is beyond Max Limit", function() {
                        it("Should create the error message", function() {
                                description = "";
                                for(var i = 0; i < 501; i++) {
                                    description += "A";
                                }

                                question =  new Question("This is title",description);

                                expect(question.isValid()).toBeFalsy();

                                expect(question.messages['description']).toEqual("Description should be less than 500 characters.");
                        });
                });

        });

        describe("On updating description", function() {

                describe("When description is empty", function() {
                        it("Should create the information message with number of characters remaining", function() {
                            question =  new Question("This is title","");
                            question.updateMessages();
                            expect(question.messages['description']).toEqual("500 characters remaining.");
                        });
                });

                describe("When Description is less than Max Limit", function() {
                        it("Should create the information message with number of characters remaining", function() {
                                question =  new Question("This is title","This is the description");

                                question.updateMessages();

                                expect(question.messages['description']).toEqual("477 characters remaining.");
                        });
                });

                describe("When Description is at Max Limit", function() {
                        it("Should create the information message with zero characters remaining", function() {
                                description = "";
                                for(var i = 0; i < 500; i++) {
                                    description += "A";
                                }

                                question =  new Question("This is title",description);

                                question.updateMessages();

                                expect(question.messages['description']).toEqual("0 characters remaining.");
                        });
                });

                describe("When Description is beyond Max Limit", function() {
                        it("Should create the error message", function() {
                                description = "";
                                for(var i = 0; i < 501; i++) {
                                    description += "A";
                                }

                                question =  new Question("This is title",description);

                                question.isValid();

                                expect(question.messages['description']).toEqual("Description should be less than 500 characters.");
                        });
                });

        });

});