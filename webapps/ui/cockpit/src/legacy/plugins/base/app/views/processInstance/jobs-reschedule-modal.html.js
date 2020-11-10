/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

module.exports = `<!-- # CE - camunda-bpm-webapp/ui/cockpit/plugins/base/app/views/processInstance/jobs-reschedule-modal.html -->
<div class="modal-header">
  <h3 class="modal-title">{{ 'PLUGIN_JOBS_MODAL_TITLE' | translate  }}</h3>
</div>

<div class="modal-body">
  <div notifications-panel></div>


  <div ng-hide="status === 'DONE'">
    <p class="">{{ 'PLUGIN_JOBS_MODAL_DESCRIPTION' | translate }}</p>
    <form name="rescheduleJobDuedateForm" class="form-horizontal">
      <fieldset>
        <div class="form-group">
          <label class="control-label col-xs-4">
                  {{'PLUGIN_JOBS_RECALCULATE' | translate}}

            <span uib-tooltip="{{'PLUGIN_JOBS_RECALCULATE_TOOLTIP' | translate}}"
                  tooltip-placement="right">
              <span class="glyphicon glyphicon-question-sign"></span>
            </span>
          </label>

          <div class="col-xs-8">
              <label class="radio">
                <input type="radio" ng-model="recalculationType" value="creation">
                {{ 'PLUGIN_JOBS_FROM_CREATION' | translate }}
              </label>

            <label class="radio">
                <input type="radio" ng-model="recalculationType" value="now">
                {{ 'PLUGIN_JOBS_FROM_NOW' | translate }}
            </label>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-xs-4">
                  {{'PLUGIN_JOBS_SPECIFIC_DATE' | translate}}

            <span uib-tooltip="{{'PLUGIN_JOBS_SPECIFIC_DATE_TOOLTIP' | translate}}"
                  tooltip-placement="right">
              <span class="glyphicon glyphicon-question-sign"></span>
            </span>
          </label>

          <div class="col-xs-8">
              <label class="radio">
                <input type="radio" ng-model="recalculationType" value="specific">
              </label>
          </div>
        </div>
        <div class="form-group"
            ng-show="recalculationType==='specific'">
          <label class="control-label col-xs-4">
            {{'PLUGIN_JOBS_CASCADE' | translate}}

          <span uib-tooltip="{{'PLUGIN_JOBS_CASCADE_TOOLTIP' | translate}}"
                tooltip-placement="right">
            <span class="glyphicon glyphicon-question-sign"></span>
          </span>
          </label>

          <div class="col-xs-8">
            <label class="checkbox">
                <input type="checkbox" ng-model="cascade">
            </label>
          </div>

          <label class="control-label col-xs-4">
            {{'PLUGIN_JOBS_DATE_INPUT' | translate}}
          </label>

          <div class="col-xs-8">
            <input date type="text" ng-model="date" name="dateValue" ng-disabled="recalculationType!=='specific'" class="form-control">
            <p class="invalid" ng-show="this.rescheduleJobDuedateForm.$error.datePattern">
              {{ 'PLUGIN_JOBS_VALID_PATTERN' | translate }}
            </p>
          </div>
        </div>
      </fieldset>
    </form>
  </div>
</div>

<div class="modal-footer">
   <button ng-click="$dismiss()"
          class="btn btn-default">
    {{ 'PLUGIN_JOBS_CLOSE' | translate }}
  </button>
  <button ng-click="submit()"
          class="btn btn-primary"
          ng-disabled="!isValid()"
          ng-hide="status === 'DONE'">

    {{ 'PLUGIN_JOBS_CHANGE' | translate }}
  </button>
</div>
<!-- / CE - camunda-bpm-webapp/ui/cockpit/plugins/base/app/views/processInstance/jobs-reschedule-modal.html -->
`;
