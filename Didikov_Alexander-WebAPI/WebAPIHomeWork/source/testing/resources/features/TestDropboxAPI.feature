Feature:
  Background:
    Given set request specification

  Scenario: upload file
    When set header Dropbox-API-Arg
    And header param request content type is application/octet-stream
    And set request body params for uploading
    And send upload POST request
    Then received response code 200

  Scenario: get file metadata
    When header param request content type is application/json
    And set request body params for getting metadata
    And send getMetadata POST request
    Then received response code 200

  Scenario: delete file
    When header param request content type is application/json
    And set request body params for deleting file
    And send delete POST request
    Then received response code 200
