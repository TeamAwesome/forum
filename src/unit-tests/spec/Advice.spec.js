describe("Advice Validation:", function() {
        var advice;

        beforeEach(function() {
            advice = new Advice("This is the description");
        });

        describe("On validating description", function() {

                describe("When description is empty", function() {
                        it("Should create the error message", function() {
                            advice =  new Advice("");
                            expect(advice.isValid()).toBeFalsy();
                            expect(advice.messages['description']).toEqual("Description is empty.");
                        });
                });

                describe("When Description is less than Max Limit", function() {
                        it("Should create the information message with number of characters remaining", function() {
                                advice =  new Advice("This is the description");

                                expect(advice.isValid()).toBeTruthy();

                                expect(advice.messages['description']).toEqual("977 characters remaining.");
                        });
                });

                describe("When Description is at Max Limit", function() {
                        it("Should create the information message with zero characters remaining", function() {
                                description = "";
                                for(var i = 0; i < 1000; i++) {
                                    description += "A";
                                }

                                advice =  new Advice(description);

                                expect(advice.isValid()).toBeTruthy();

                                expect(advice.messages['description']).toEqual("0 characters remaining.");
                        });
                });

                describe("When Description is beyond Max Limit", function() {
                        it("Should create the error message", function() {
                                description = "";
                                for(var i = 0; i < 1001; i++) {
                                    description += "A";
                                }

                                advice =  new Advice(description);

                                expect(advice.isValid()).toBeFalsy();

                                expect(advice.messages['description']).toEqual("Description should be less than 1000 characters.");
                        });
                });

        });

        describe("On updating description", function() {

                describe("When description is empty", function() {
                        it("Should create the information message with number of characters remaining", function() {
                            advice =  new Advice("");
                            advice.updateMessages();
                            expect(advice.messages['description']).toEqual("1000 characters remaining.");
                        });
                });

                describe("When Description is less than Max Limit", function() {
                        it("Should create the information message with number of characters remaining", function() {
                                advice =  new Advice("This is the description");

                                advice.updateMessages();

                                expect(advice.messages['description']).toEqual("977 characters remaining.");
                        });
                });

                describe("When Description is at Max Limit", function() {
                        it("Should create the information message with zero characters remaining", function() {
                                description = "";
                                for(var i = 0; i < 1000; i++) {
                                    description += "A";
                                }

                                advice =  new Advice(description);

                                advice.updateMessages();

                                expect(advice.messages['description']).toEqual("0 characters remaining.");
                        });
                });

                describe("When Description is beyond Max Limit", function() {
                        it("Should create the error message", function() {
                                description = "";
                                for(var i = 0; i < 1001; i++) {
                                    description += "A";
                                }

                                advice =  new Advice(description);

                                advice.isValid();

                                expect(advice.messages['description']).toEqual("Description should be less than 1000 characters.");
                        });
                });

        });

});