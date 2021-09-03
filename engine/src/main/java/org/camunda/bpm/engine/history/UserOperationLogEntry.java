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
package org.camunda.bpm.engine.history;

import org.camunda.bpm.engine.EntityTypes;

import java.util.Date;


/**
 * Log entry about an operation performed by a user. This is used for logging
 * actions such as creating a new task, completing a task,
 * canceling a process instance, ...
 *
 * <h2>Operation Type</h2>
 * <p>The type of the operation which has been performed. A user may create a new task,
 * complete a task, delegate a tasks, etc... Check this class for a list of built-in
 * operation type constants.</p>
 *
 * <h2>Entity Type</h2>
 * <p>The type of the entity on which the operation was performed. Operations may be
 * performed on tasks, attachments, ...</p>
 *
 * <h2>Affected Entity Criteria</h2>
 * <p>
 *   The methods that reference other entities (except users), such as {@link #getProcessInstanceId()}
 *   or {@link #getProcessDefinitionId()}, describe which entities were affected
 *   by the operation and represent restriction criteria.
 *   A <code>null</code> return value of any of those methods means that regarding
 *   this criterion, any entity was affected.
 * </p>
 * <p>
 *   For example, if an operation suspends all process instances that belong to a certain
 *   process definition id, one operation log entry is created.
 *   Its return value for the method {@link #getProcessInstanceId()} is <code>null</code>,
 *   while {@link #getProcessDefinitionId()} returns an id. Thus, the return values
 *   of these methods can be understood as selection criteria of instances of the entity type
 *   that were affected by the operation.
 * </p>
 *
 * <h2>Additional Considerations</h2>
 * <p>The event describes which user has requested out the operation and the time
 * at which the operation was performed. Furthermore, one operation can result in multiple
 * {@link UserOperationLogEntry} entities whicha are linked by the value of the
 * {@link #getOperationId()} method.</p>
 *
 * @author Danny Gräf
 * @author Daniel Meyer
 *
 */
public interface UserOperationLogEntry {

  /** @deprecated Please use {@link EntityTypes#TASK} instead. */
  @Deprecated
  static String ENTITY_TYPE_TASK = EntityTypes.TASK;
  /** @deprecated Please use {@link EntityTypes#IDENTITY_LINK} instead. */
  @Deprecated
  static String ENTITY_TYPE_IDENTITY_LINK = EntityTypes.IDENTITY_LINK;
  /** @deprecated Please use {@link EntityTypes#ATTACHMENT} instead. */
  @Deprecated
  static String ENTITY_TYPE_ATTACHMENT = EntityTypes.ATTACHMENT;

  static String OPERATION_TYPE_ASSIGN = "Assign";
  static String OPERATION_TYPE_CLAIM = "Claim";
  static String OPERATION_TYPE_COMPLETE = "Complete";
  static String OPERATION_TYPE_CREATE = "Create";
  static String OPERATION_TYPE_DELEGATE = "Delegate";
  static String OPERATION_TYPE_DELETE = "Delete";
  static String OPERATION_TYPE_RESOLVE = "Resolve";
  static String OPERATION_TYPE_SET_OWNER = "SetOwner";
  static String OPERATION_TYPE_SET_PRIORITY = "SetPriority";
  static String OPERATION_TYPE_UPDATE = "Update";
  static String OPERATION_TYPE_ACTIVATE = "Activate";
  static String OPERATION_TYPE_SUSPEND = "Suspend";
  static String OPERATION_TYPE_MIGRATE = "Migrate";
  static String OPERATION_TYPE_ADD_USER_LINK = "AddUserLink";
  static String OPERATION_TYPE_DELETE_USER_LINK = "DeleteUserLink";
  static String OPERATION_TYPE_ADD_GROUP_LINK = "AddGroupLink";
  static String OPERATION_TYPE_DELETE_GROUP_LINK = "DeleteGroupLink";
  static String OPERATION_TYPE_SET_DUEDATE = "SetDueDate";
  static String OPERATION_TYPE_RECALC_DUEDATE = "RecalculateDueDate";
  static String OPERATION_TYPE_UNLOCK = "Unlock";
  static String OPERATION_TYPE_EXECUTE = "Execute";
  static String OPERATION_TYPE_EVALUATE = "Evaluate";

  static String OPERATION_TYPE_ADD_ATTACHMENT = "AddAttachment";
  static String OPERATION_TYPE_DELETE_ATTACHMENT = "DeleteAttachment";

  static String OPERATION_TYPE_SUSPEND_JOB_DEFINITION = "SuspendJobDefinition";
  static String OPERATION_TYPE_ACTIVATE_JOB_DEFINITION = "ActivateJobDefinition";
  static String OPERATION_TYPE_SUSPEND_PROCESS_DEFINITION = "SuspendProcessDefinition";
  static String OPERATION_TYPE_ACTIVATE_PROCESS_DEFINITION = "ActivateProcessDefinition";

  static String OPERATION_TYPE_CREATE_HISTORY_CLEANUP_JOB = "CreateHistoryCleanupJobs";
  static String OPERATION_TYPE_UPDATE_HISTORY_TIME_TO_LIVE = "UpdateHistoryTimeToLive";
  static String OPERATION_TYPE_DELETE_HISTORY = "DeleteHistory";

  static String OPERATION_TYPE_MODIFY_PROCESS_INSTANCE = "ModifyProcessInstance";
  static String OPERATION_TYPE_RESTART_PROCESS_INSTANCE  = "RestartProcessInstance";
  static String OPERATION_TYPE_SUSPEND_JOB = "SuspendJob";
  static String OPERATION_TYPE_ACTIVATE_JOB = "ActivateJob";
  static String OPERATION_TYPE_SET_JOB_RETRIES = "SetJobRetries";
  static String OPERATION_TYPE_SET_EXTERNAL_TASK_RETRIES = "SetExternalTaskRetries";
  static String OPERATION_TYPE_SET_VARIABLE = "SetVariable";
  static String OPERATION_TYPE_SET_VARIABLES = "SetVariables";

  static String OPERATION_TYPE_REMOVE_VARIABLE = "RemoveVariable";
  static String OPERATION_TYPE_MODIFY_VARIABLE = "ModifyVariable";

  static String OPERATION_TYPE_SUSPEND_BATCH = "SuspendBatch";
  static String OPERATION_TYPE_ACTIVATE_BATCH = "ActivateBatch";

  static String OPERATION_TYPE_CREATE_INCIDENT = "CreateIncident";

  static String OPERATION_TYPE_SET_REMOVAL_TIME = "SetRemovalTime";

  static String OPERATION_TYPE_SET_ANNOTATION = "SetAnnotation";
  static String OPERATION_TYPE_CLEAR_ANNOTATION = "ClearAnnotation";

  static String OPERATION_TYPE_CORRELATE_MESSAGE = "CorrelateMessage";

  static String CATEGORY_ADMIN = "Admin";
  static String CATEGORY_OPERATOR = "Operator";
  static String CATEGORY_TASK_WORKER = "TaskWorker";

  /** The unique identifier of this log entry. */
  String getId();

  /** Deployment reference */
  String getDeploymentId();

  /** Process definition reference. */
  String getProcessDefinitionId();

  /**
   * Key of the process definition this log entry belongs to; <code>null</code> means any.
   */
  String getProcessDefinitionKey();

  /** Root process instance reference. */
  String getRootProcessInstanceId();

  /** Process instance reference. */
  String getProcessInstanceId();

  /** Execution reference. */
  String getExecutionId();

  /** Case definition reference. */
  String getCaseDefinitionId();

  /** Case instance reference. */
  String getCaseInstanceId();

  /** Case execution reference. */
  String getCaseExecutionId();

  /** Task instance reference. */
  String getTaskId();

  /** Job instance reference. */
  String getJobId();

  /** Job definition reference. */
  String getJobDefinitionId();

  /** Batch reference. */
  String getBatchId();

  /** The User who performed the operation */
  String getUserId();

  /** Timestamp of this change. */
  Date getTimestamp();

  /**
   * The unique identifier of this operation.
   *
   * If an operation modifies multiple properties, multiple {@link UserOperationLogEntry} instances will be
   * created with a common operationId. This allows grouping multiple entries which are part of a composite operation.
   */
  String getOperationId();

  /** External task reference. */
  String getExternalTaskId();

  /**
   * Type of this operation, like create, assign, claim and so on.
   *
   * @see #OPERATION_TYPE_ASSIGN and other fields beginning with OPERATION_TYPE
   */
  String getOperationType();

  /**
   * The type of the entity on which this operation was executed.
   *
   * @see #ENTITY_TYPE_TASK and other fields beginning with ENTITY_TYPE
   */
  String getEntityType();

  /** The property changed by this operation. */
  String getProperty();

  /** The original value of the property. */
  String getOrgValue();

  /** The new value of the property. */
  String getNewValue();

  /** The time the historic user operation log will be removed. */
  Date getRemovalTime();

  /** The category this entry is associated with */
  String getCategory();

  /** An arbitrary annotation set by a user for auditing reasons */
  String getAnnotation();

}
