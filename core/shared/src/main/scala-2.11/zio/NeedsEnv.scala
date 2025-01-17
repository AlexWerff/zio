/*
 * Copyright 2017-2019 John A. De Goes and the ZIO Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

package zio

import scala.annotation.implicitNotFound

/**
 * A value of type `NeedsEnv[R]` provides implicit evidence that an effect with
 * environment type `R` needs an environment, that is, that `R` is not equal to
 * `Any`.
 */
@implicitNotFound("This operation only makes sense for effects that need an environment.")
sealed trait NeedsEnv[+R]

object NeedsEnv extends NeedsEnv[Nothing] {

  implicit final def needsEnv[R]: NeedsEnv[R] = NeedsEnv

  // Provide multiple ambiguous values so an implicit NeedsEnv[Any] cannot be found.
  implicit final val needsEnvAmbiguous1: NeedsEnv[Any] = NeedsEnv
  implicit final val needsEnvAmbiguous2: NeedsEnv[Any] = NeedsEnv
}
